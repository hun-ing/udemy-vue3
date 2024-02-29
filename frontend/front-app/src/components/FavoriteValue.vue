<template>
  <h3>{{counter}}</h3>
  <p>We do more...</p>
</template>

<script setup>
import { useCounterStore } from '@/stores/counter/index.js'
import {computed} from "vue";

const createStore = useCounterStore();
const counter = computed(() => createStore.normalizedCounter);
</script>

<style scoped>
</style>