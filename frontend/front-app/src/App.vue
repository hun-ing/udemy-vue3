<template>
  <ul>
    <LearningResource v-for="res in storedResources" :key="res.id" :title="res.title" :description="res.description" :link="res.link" />
  </ul>
</template>

<script setup>
import {ref} from "vue";
import LearningResource from "@/components/learning-resources/LearningResource.vue";

const storedResources = ref([
  { id: 'test1', title: 'Test1', description: 'test111', link: 'https://vuejs.org'},
  { id: 'test2', title: 'Test2', description: 'test222', link: 'https://google.org'},
]);
</script>

<style>
</style>
