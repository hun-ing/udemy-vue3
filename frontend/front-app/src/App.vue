<template>
  <TheHeader title="RememberMe"/>
  <StoredResources :resources/>
</template>

<script setup>
import {ref} from "vue";
import StoredResources from "@/components/learning-resources/StoredResources.vue";
import TheHeader from "@/components/layouts/TheHeader.vue";

const resources = ref([
  {id: 'test1', title: 'Test1', description: 'test111', link: 'https://vuejs.org'},
  {id: 'test2', title: 'Test2', description: 'test222', link: 'https://google.org'},
]);
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap');

* {
  box-sizing: border-box;
}

html {
  font-family: 'Roboto', sans-serif;
}

body {
  margin: 0;
}
</style>
