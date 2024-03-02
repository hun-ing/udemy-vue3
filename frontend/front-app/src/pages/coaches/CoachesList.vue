<template>
  <div>
    <BaseDialog :show="!!error" title="An error occurred!" @close="dialogHandleError">
      <p>{{ error }}</p>
    </BaseDialog>
    <section>
      <CoachFilter @change-filter="setFilters"></CoachFilter>
    </section>
    <section>
      <BaseCard>
        <div class="controls">
          <BaseButton mode="outline" @click="loadCoaches">Refresh</BaseButton>
          <BaseButton v-if="!isCoach && !isLoading" link to="/register">Register as Coach</BaseButton>
        </div>
        <div v-if="isLoading">
          <BaseSpinner></BaseSpinner>
        </div>
        <ul v-else-if="hasCoaches">
          <CoachItem v-for="coach in coachesStore.getCoachesByAreas(activeFilters)" :key="coach.id" :id="coach.id"
                     :first-name="coach.firstName"
                     :last-name="coach.lastName" :rate="coach.hourlyRate" :areas="coach.areas" />
        </ul>
        <h3 v-else>No coaches found.</h3>
      </BaseCard>
    </section>
  </div>

</template>

<script setup>
import {useCoachesStore} from '@/stores/coaches/index.js';
import CoachItem from '@/components/coaches/CoachItem.vue';
import CoachFilter from '@/components/coaches/CoachFilter.vue';
import {onMounted, ref} from 'vue';

const coachesStore = useCoachesStore();

const isLoading = ref(false);
const isCoach = ref(false);
const activeFilters = ref({
  frontend: true,
  backend: true,
  career: true,
});
const error = ref(null);
const setFilters = (updatedFilters) => {
  activeFilters.value = updatedFilters;
};
const hasCoaches = () => !isLoading.value && coachesStore.hasCoaches();
const loadCoaches = async () => {
  isLoading.value = true;
  isCoach.value = false;
  try {
    await coachesStore.loadCoaches();
  } catch (e) {
    error.value = e.message || 'Something went wrong!';
  }
  isCoach.value = coachesStore.isCoach;
  isLoading.value = false;
};
const dialogHandleError = () => error.value = null;

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