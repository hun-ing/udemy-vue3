<template>
  <h3>{{counter}}</h3>
  <p>We do more...</p>
</template>

<script setup>
import { useCreateStore } from '@/stores/useCreateStore.js'
import {computed} from "vue";

const createStore = useCreateStore();
const counter = computed(() => createStore.normalizedCounter);
</script>

<style scoped>
</style>