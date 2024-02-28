<template>
  <section>
    <h2>{{ teamName }}</h2>
    <ul>
      <UserItem
        v-for="member in members"
        :key="member.id"
        :name="member.fullName"
        :role="member.role"
      ></UserItem>
    </ul>
    <router-link to="/teams/t2">Go to Team 2</router-link>
  </section>
</template>

<script setup>
import UserItem from '@/components/users/UserItem.vue'
import {inject, onMounted, ref, watch} from 'vue'
import {onBeforeRouteUpdate} from "vue-router";

const users = inject('users');
const teams = inject('teams');

const teamName = ref('Test')
const members = ref([])

const props = defineProps(['teamId']);

const loadTeamMembers = (teamId) => {
  members.value = [];
  const selectedTeam = teams.find(team => team.id === teamId);
  const selectedMembers = selectedTeam.members;

  for (const member of selectedMembers) {
    const selectedUser = users.find(user => user.id === member);
    members.value.push(selectedUser)
  }

  teamName.value = selectedTeam.name;
}

onMounted(() => loadTeamMembers(props.teamId));
watch(props, (newProps) => loadTeamMembers(newProps.teamId));

onBeforeRouteUpdate((to, from, next) => {
  console.log('onBeforeRouteUpdate...');
  console.log(to, from)
  // loadTeamMembers(to.params.teamId);
  next();
})
</script>

<style scoped>
section {
  margin: 2rem auto;
  max-width: 40rem;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.26);
  padding: 1rem;
  border-radius: 12px;
}

h2 {
  margin: 0.5rem 0;
}

ul {
  list-style: none;
  margin: 0;
  padding: 0;
}
</style>