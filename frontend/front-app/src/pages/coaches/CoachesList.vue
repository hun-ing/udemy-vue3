<template>
  <BaseDialog :show="!!error" title="An error occurred!" @close="dialogHandleError">
    <p>{{error}}</p>
  </BaseDialog>
  <section>
    <CoachFilter @change-filter="setFilters"></CoachFilter>
  </section>
  <section>
    <BaseCard>
      <div class="controls">
        <BaseButton mode="outline" @click="coachesStore.loadCoaches()">Refresh</BaseButton>
        <BaseButton v-if="!coachesStore.isCoach && !isLoading" link to="/register">Register as Coach</BaseButton>
      </div>
      <div v-if="isLoading">
        <BaseSpinner></BaseSpinner>
      </div>
      <ul v-else-if="hasCoaches">
        <CoachItem v-for="coach in coachesStore.getCoachesByAreas(activeFilters)" :key="coach.id" :id="coach.id" :first-name="coach.firstName"
                   :last-name="coach.lastName" :rate="coach.hourlyRate" :areas="coach.areas"/>
      </ul>
      <h3 v-else>No coaches found.</h3>
    </BaseCard>
  </section>
</template>

<script setup>
import {useCoachesStore} from "@/stores/coaches/index.js";
import CoachItem from "@/components/coaches/CoachItem.vue";
import CoachFilter from "@/components/coaches/CoachFilter.vue";
import {onMounted, ref} from 'vue';

const coachesStore = useCoachesStore();

const isLoading = ref(false);
const activeFilters = ref({
  frontend: true,
  backend: true,
  career: true
});
const error = ref(null);
const setFilters = (updatedFilters) => {
  activeFilters.value = updatedFilters
}
const hasCoaches = () => !isLoading.value && coachesStore.hasCoaches();
const loadCoaches = async () => {
  isLoading.value = true;
  try {
    await coachesStore.loadCoaches();
  } catch (e) {
    error.value = e.message || 'Something went wrong!';
  }
  isLoading.value = false;
}
const dialogHandleError = () => error.value = false;

onMounted(() => loadCoaches());
</script>

<style scoped>
ul {
  list-style: none;
  margin: 0;
  padding: 0;
}

.controls {
  display: flex;
  justify-content: space-between;
}
</style>