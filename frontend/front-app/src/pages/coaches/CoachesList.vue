<template>
  <section>
    <CoachFilter @change-filter="setFilters"></CoachFilter>
  </section>
  <section>
    <BaseCard>
      <div class="controls">
        <BaseButton mode="outline">Refresh</BaseButton>
        <BaseButton v-if="!coachesStore.isCoach" link to="/register">Register as Coach</BaseButton>
      </div>
      <ul v-if="coachesStore.hasCoaches">
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
import {ref} from "vue";

const coachesStore = useCoachesStore();

const activeFilters = ref({
  frontend: true,
  backend: true,
  career: true
});
const setFilters = (updatedFilters) => {
  activeFilters.value = updatedFilters
}
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