<template>
  <ul>
    <LearningResource v-for="res in resources" :key="res.id" :id="res.id" :title="res.title" :description="res.description" :link="res.link" />
  </ul>
</template>

<script setup>
import LearningResource from "@/components/learning-resources/LearningResource.vue";
import {inject} from "vue";

const resources = inject('resources');
</script>

<style scoped>
ul {
  list-style: none;
  margin: 0;
  padding: 0;
  margin: auto;
  max-width: 40rem;
}
</style>