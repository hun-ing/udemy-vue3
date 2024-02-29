<template>
  <TheHeader></TheHeader>
  <router-view></router-view>
</template>

<script setup>
import TheHeader from "@/components/nav/TheHeader.vue"
import {useGlobalStore} from "@/stores/index.js";
const globalStore = useGlobalStore();
globalStore.incrementIndex();
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