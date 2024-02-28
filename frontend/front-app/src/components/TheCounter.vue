<template>
  <h3>{{counter}}</h3>
</template>

<script setup>
import { useCreateStore } from '@/stores/useCreateStore.js'
import {computed} from "vue";
const createStore = useCreateStore();

const counter = computed(() => createStore.finalCounter);
</script>

<style scoped>
</style>