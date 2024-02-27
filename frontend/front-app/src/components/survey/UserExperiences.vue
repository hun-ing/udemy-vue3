<template>
  <section>
    <BaseCard>
      <h2>Submitted Experiences</h2>
      <div>
        <BaseButton @click="loadExperiences">Load Submitted Experiences</BaseButton>
      </div>
      <p v-if="isLoading">Loading...</p>
      <p v-else-if="!isLoading && errorMessage">{{ errorMessage }}</p>
      <p v-else-if="!isLoading && (results.length === 0)">No stored experiences found. Start adding some survey results first.</p>
      <ul v-else>
        <SurveyResult
            v-for="result in results"
            :key="result.id"
            :name="result.name"
            :rating="result.rating"
        ></SurveyResult>
      </ul>
    </BaseCard>
  </section>
</template>

<script setup>
import SurveyResult from "@/components/survey/SurveyResult.vue";
import {onMounted, ref} from "vue";
import {useFetch} from "@vueuse/core";

const results = ref([]);
const isLoading = ref(false);
const errorMessage = ref(null);
const loadExperiences = async () => {
  isLoading.value = true;
  errorMessage.value = null;
  const {data, error} = await useFetch('http://localhost:8080/api/survey');

  if (error.value) {
    errorMessage.value = 'Failed to fetch data - please try again later.';
  } else {
    results.value.push(...JSON.parse(data.value));
  }

  isLoading.value = false;
}

onMounted(() => loadExperiences());
</script>

<style scoped>
ul {
  list-style: none;
  margin: 0;
  padding: 0;
}
</style>