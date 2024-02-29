<template>
  <section>
    <BaseCard>
      <h2>Register as a coach now!</h2>
      <CoachForm @save-data="saveData"></CoachForm>
    </BaseCard>
  </section>
</template>

<script setup>
import CoachForm from "@/components/coaches/CoachForm.vue";
import {useCoachesStore} from "@/stores/coaches/index.js";
const coachesStore = useCoachesStore();
const saveData = (data) => coachesStore.registerCoach(data);
</script>

<style scoped>

</style>