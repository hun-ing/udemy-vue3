<template>
  <v-app>
    <component :is="layout">
      <router-view />
    </component>
  </v-app>
</template>

<script setup>
import { computed, onMounted, watch } from "vue";
import { useAuthStore } from '@/stores/auth/index.js'
import { useRouter } from 'vue-router'
import { useRoute } from 'vue-router';

const authStore = useAuthStore()
const router = useRouter()
onMounted(() => {
  console.log('App onMounted...')
  authStore.tryLogin()
})

const didAutoLogout = computed(() => authStore.getDidAutoLogout)

watch(didAutoLogout, (curValue, oldValue) => {
  console.log('App Watches...')
  if (curValue && curValue !== oldValue) {
    router.replace('/coaches')
  }
})

const route = useRoute();
const layout = computed(() => {
  console.log("layout computed...");
  console.log(route?.meta);
  const layout = route?.meta?.layout;
  return layout ? layout : 'div';
});
</script>
