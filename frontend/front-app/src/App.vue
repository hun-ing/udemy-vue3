<template>
  <div>
    <TheHeader/>
    <button @click="setSelectedComponent(ActiveGoals)">Active Goals</button>
    <button @click="setSelectedComponent(ManageGoals)">Manage Goals</button>
<!--    <ActiveGoals v-if="selectedComponent === 'active-goals'"></ActiveGoals>
    <ManageGoals v-if="selectedComponent === 'manage-goals'"></ManageGoals>-->
    <keep-alive>
      <component :is="selectedComponent"></component>
    </keep-alive>
  </div>
</template>

<script setup>
import TheHeader from "@/components/layout/TheHeader.vue";
import {ref} from "vue";
import ActiveGoals from "@/components/ActiveGoals.vue";
import ManageGoals from "@/components/ManageGoals.vue";

const activeUser = ref({
  name: 'Maximilian Schwarzmüller',
  description: 'Site owner and admin',
  role: 'admin',
});

const selectedComponent = ref(ActiveGoals);
const setSelectedComponent = (cmp) => {
  selectedComponent.value = cmp;
}
</script>

<style>
html {
  font-family: sans-serif;
}

body {
  margin: 0;
}
</style>