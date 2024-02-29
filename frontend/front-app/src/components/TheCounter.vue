<template>
  <h3>{{ state.counter() }}</h3>
  <h3>{{ store.finalCounter }}</h3>
</template>

<script setup>
import {useCounterStore} from '@/stores/counter/index.js'
import {mapState} from "pinia";
const store = useCounterStore();
const state = mapState(useCounterStore, ['finalCounter', 'normalizedCounter', 'counter']);
</script>

<style scoped>
</style>