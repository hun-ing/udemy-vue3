<template>
  <v-app>
    <TheNav />
    <TheHeader />

    <v-main>
      <v-container
        fluid
      >
        <router-view v-slot="slotProps">
          <transition
            name="route"
            mode="out-in"
          >
            <component :is="slotProps.Component" />
          </transition>
        </router-view>
      </v-container>
    </v-main>
  </v-app>
</template>

<script setup>
import TheHeader from '@/components/layouts/TheHeader.vue'
import TheNav from "@/components/layouts/TheNav.vue";
import { computed, onMounted, ref, watch } from "vue";
import { useAuthStore } from '@/stores/auth/index.js'
import { useRouter } from 'vue-router'

const drawer = ref(true)
const rail = ref(false)

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
</script>
