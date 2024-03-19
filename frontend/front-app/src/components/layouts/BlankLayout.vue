<template>
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
</script>