<template>
  <BaseContainer title="Vuex">
    <h3>{{counter}}</h3>
    <button @click="addOne">Add 1</button>
  </BaseContainer>
</template>

<script setup>
import BaseContainer from "@/components/BaseContainer.vue";
import {useCreateStore} from "@/main.js";
import {computed} from "vue";
const createStore = useCreateStore();

const counter = computed(() => createStore.counter);
const addOne = () => createStore.counter++;
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