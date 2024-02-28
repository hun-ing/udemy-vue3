<template>
  <router-view></router-view>
  <ul>
    <TeamsItem
      v-for="team in teams"
      :key="team.id"
      :id="team.id"
      :name="team.name"
      :member-count="team.members.length"
    ></TeamsItem>
  </ul>
</template>

<script setup>
import { inject } from 'vue'
import TeamsItem from '@/components/teams/TeamsItem.vue'

const teams = inject('teams')
</script>

<style scoped>
ul {
  list-style: none;
  margin: 2rem auto;
  max-width: 40rem;
  padding: 0;
}
</style>