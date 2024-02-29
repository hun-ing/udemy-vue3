<template>
  <BaseContainer title="Vuex" v-if="userAuthStore.userIsAuthenticated">
    <TheCounter></TheCounter>
    <FavoriteValue></FavoriteValue>
    <button @click="addOne">Add 10</button>
    <ChangeCounter></ChangeCounter>
  </BaseContainer>
  <BaseContainer title="Auth">
    <UserAuth></UserAuth>
  </BaseContainer>
</template>

<script setup>
import TheCounter from '@/components/TheCounter.vue'
import BaseContainer from '@/components/BaseContainer.vue'
import ChangeCounter from '@/components/ChangeCounter.vue'
import { useCounterStore } from '@/stores/counter/index.js'
import FavoriteValue from '@/components/FavoriteValue.vue'
import UserAuth from "@/components/UserAuth.vue";
import {useUserAuthStore} from "@/stores/userAuth/index.js";

const createStore = useCounterStore()
const userAuthStore = useUserAuthStore();
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