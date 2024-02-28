<template>
  <BaseContainer title="Vuex">
    <TheCounter></TheCounter>
    <FavoriteValue></FavoriteValue>
    <button @click="addOne">Add 10</button>
    <ChangeCounter></ChangeCounter>
  </BaseContainer>
</template>

<script setup>
import TheCounter from '@/components/TheCounter.vue'
import BaseContainer from '@/components/BaseContainer.vue'
import ChangeCounter from '@/components/ChangeCounter.vue'
import { useCreateStore } from '@/stores/useCreateStore.js'
import FavoriteValue from '@/components/FavoriteValue.vue'

const createStore = useCreateStore()
const addOne = () => createStore.increase(10)
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