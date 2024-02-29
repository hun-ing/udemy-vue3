<template>
  <section>
    <BaseCard>
      <h2>{{coachesStore.getFullNameById(props.id)}}</h2>
      <h3>${{ rate }}/hour</h3>
    </BaseCard>
  </section>
  <section>
    <BaseCard>
      <header>
        <h2>Interested? Reach out now!</h2>
        <BaseButton link :to="contactLink">Contact</BaseButton>
      </header>
      <router-view></router-view>
    </BaseCard>
  </section>
  <section>
    <BaseCard>
      <BaseBadge v-for="area in areas" :key="area" :type="area" :title="area"/>
      <p>{{description}}</p>
    </BaseCard>
  </section>
</template>

<script setup>
import {computed, ref} from "vue";
import {useCoachesStore} from "@/stores/coaches/index.js";
import {useRoute} from "vue-router";

const route = useRoute();
const coachesStore = useCoachesStore();
const props = defineProps(['id']);
const selectedCoach = ref(null);
const contactLink = computed(() => `${route.path}/contact`);
const areas = computed(() => selectedCoach.value.areas);
const rate = computed(() => selectedCoach.value.hourlyRate);
const description = computed(() => selectedCoach.value.description);

function created() {
  selectedCoach.value = coachesStore.findCoachById(props.id);
}
created();
</script>

<style scoped>

</style>