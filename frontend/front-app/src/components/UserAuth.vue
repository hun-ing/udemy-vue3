<template>
  <button @click="store.login" v-if="!store.userIsAuthenticated">Login</button>
  <button @click="store.logout" v-else>Logout</button>
</template>

<script setup>
import {useUserAuthStore} from "@/stores/userAuth/index.js";

const store = useUserAuthStore();
</script>

<style scoped>

</style>