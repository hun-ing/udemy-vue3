<template>
  <ul>
    <UserItem v-for="user in users" :key="user.id" :name="user.fullName" :role="user.role"></UserItem>
  </ul>
</template>

<script setup>
import UserItem from '@/components/users/UserItem.vue'
import { inject } from 'vue'

const users = inject('users')
</script>

<style scoped>
ul {
  list-style: none;
  margin: 2rem auto;
  max-width: 20rem;
  padding: 0;
}
</style>