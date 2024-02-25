<template>
  <LearningSurvey></LearningSurvey>
  <UserExperiences></UserExperiences>
</template>

<script setup>
import LearningSurvey from "@/components/survey/LearningSurvey.vue";
import UserExperiences from "@/components/survey/UserExperiences.vue";
import {ref} from "vue";

// const savedSurveyResults = ref([]);
// const storeSurvey = (surveyData) => {
//   const surveyResult = {
//     name: surveyData.userName,
//     rating: surveyData.rating,
//     id: new Date().toISOString(),
//   };
//   savedSurveyResults.value.push(surveyResult);
//   console.log(surveyResult);
// }
</script>

<style>
* {
  box-sizing: border-box;
}

html {
  font-family: sans-serif;
}

body {
  margin: 0;
}
</style>