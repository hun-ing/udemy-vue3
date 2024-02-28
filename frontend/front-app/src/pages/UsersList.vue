<template>
  <button @click="confirmInput">Confirm</button>
  <button @click="saveChanges">Save Changes</button>
  <ul>
    <UserItem v-for="user in users" :key="user.id" :name="user.fullName" :role="user.role"></UserItem>
  </ul>
</template>

<script>
export default {
  beforeRouteEnter(to, from, next) {
    console.log('UsersList Cmp beforeRouteEnter');
    console.log(to, from);
    next();
  }
}
</script>

<script setup>
import UserItem from '@/components/users/UserItem.vue'
import {inject, ref} from 'vue'
import {onBeforeRouteLeave, useRouter} from "vue-router";
const router = useRouter();
const users = inject('users')
const confirmInput = () => router.push('/teams');

const changesSaved = ref(false);
const saveChanges = () => changesSaved.value = true;

onBeforeRouteLeave((to, from, next) => {
  console.log('UsersList Cmp beforeRouteLeave');
  console.log(to, from);
  if (changesSaved.value) {
    next();
  } else {
    const userWantsToLeave = confirm('나가시겠습니까?');
    next(userWantsToLeave);
  }
})
</script>

<style scoped>
ul {
  list-style: none;
  margin: 2rem auto;
  max-width: 20rem;
  padding: 0;
}
</style>