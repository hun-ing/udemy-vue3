<template>
  <v-app-bar
    image="@/assets/bg-display-01.webp"
    color="primary"
    height="80"
  >
    <v-app-bar-nav-icon
      variant="text"
      @click.stop="globalStore.toggleRail"
    />
    <v-spacer />
  </v-app-bar>
</template>

<script setup>
import { useGlobalStore } from "@/stores/index.js";

const globalStore = useGlobalStore();
</script>
