<template>
  <button @click="actions.increment()">Add 1</button>
</template>

<script setup>
import { useCounterStore } from '@/stores/counter/index.js'
import {mapActions} from "pinia";
const actions = mapActions(useCounterStore, ['increase', 'increment']);
</script>

<style scoped>
</style>