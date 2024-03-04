<template>
  <TheHeader></TheHeader>
  <router-view v-slot="slotProps">
    <transition name="route" mode="out-in">
      <component :is="slotProps.Component"></component>
    </transition>
  </router-view>
</template>

<script setup>
import TheHeader from "@/components/layouts/TheHeader.vue";
import {computed, onMounted, watch} from "vue";
import {useAuthStore} from "@/stores/auth/index.js";
import {useRouter} from "vue-router";

const authStore = useAuthStore();
const router = useRouter();
onMounted(() => {
  console.log('App onMounted...')
  authStore.tryLogin()
})

const didAutoLogout = computed(() => authStore.getDidAutoLogout);

watch(didAutoLogout, (curValue, oldValue) => {
  console.log('App Watches...');
  if (curValue && curValue !== oldValue) {
    router.replace('/coaches');
  }
})
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap");

* {
  box-sizing: border-box;
}

html {
  font-family: "Roboto", sans-serif;
}

body {
  margin: 0;
}

.route-enter-from {
  opacity: 0;
  transform: translateY(-30px);
}

.route-leave-to {
  opacity: 0;
  transform: translateY(30px);
}

.route-enter-active {
  transition: all 0.3s ease-out;
}

.route-leave-active {
  transition: all 0.3s ease-in;
}

.route-enter-to,
.route-leave-from {
  opacity: 1;
  transform: translateY(0);
}
</style>