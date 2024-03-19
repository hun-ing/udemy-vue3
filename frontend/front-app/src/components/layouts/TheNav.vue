<template>
  <v-navigation-drawer
    v-model="drawer"
    :rail="globalStore.getRail"
    permanent
    class="bg-grey-darken-3"
  >
    <v-list-item>
      <v-img
        cover
        height="72"
        src="@/assets/logo_default_72px@2x.webp"
      />
    </v-list-item>

    <v-divider />

    <v-list
      :lines="false"
      density="compact"
      nav
    >
      <v-list-item
        v-for="(item, i) in items"
        :key="i"
        link
        :to="item.to"
        active-class="primary"
        color="primary"
      >
        <template #prepend>
          <v-icon :icon="item.icon" />
        </template>

        <v-list-item-title>{{ item.text }}</v-list-item-title>
      </v-list-item>
    </v-list>
  </v-navigation-drawer>

  <!--  <header>
    <nav>
      <h1>
        <router-link to="/">Find a Coach</router-link>
      </h1>
      <ul>
        <li>
          <router-link to="/coaches">All Coaches</router-link>
        </li>
        <li v-if="authStore.isAuthenticated">
          <router-link to="/requests">Requests</router-link>
        </li>
        <li v-else>
          <router-link to="/auth">Login</router-link>
        </li>
        <li v-if="authStore.isAuthenticated">
          <BaseButton @click="logout">Logout</BaseButton>
        </li>
      </ul>
    </nav>
  </header>-->
</template>

<script setup>
import { useAuthStore } from '@/stores/auth/index.js'
import { useRouter } from 'vue-router'
import { ref } from 'vue'
import { useGlobalStore } from "@/stores/index.js";

const globalStore = useGlobalStore();

const drawer = ref(true)


const items = ref([
  { text: 'All Coaches', icon: 'mdi-folder', to: '/coaches' },
  { text: 'Requests', icon: 'mdi-account-multiple', to: '/requests' },
  { text: 'auth', icon: 'mdi-star', to: '/auth' },
])

const authStore = useAuthStore()
const router = useRouter()

const logout = () => {
  authStore.logout()
}
</script>