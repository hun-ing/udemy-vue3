<template>
  <button @click="addOne">Add 1</button>
</template>

<script setup>
import { useCreateStore } from '@/stores/useCreateStore.js'

const createStore = useCreateStore()
const addOne = () => createStore.increment()
</script>

<style scoped>
</style>