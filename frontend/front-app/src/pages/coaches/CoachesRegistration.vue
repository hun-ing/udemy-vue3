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
import { useRouter } from 'vue-router'
const router = useRouter()
const coachesStore = useCoachesStore();
const saveData = (data) => {
  coachesStore.registerCoach(data)
  router.replace('/coaches')
}
</script>

<style scoped>

</style>