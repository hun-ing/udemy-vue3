<template>
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
</template>


<script setup>
import TheNav from '@/components/layouts/TheNav.vue';
import TheHeader from '@/components/layouts/TheHeader.vue';
</script>