<template>
  <section>
    <BaseCard>
      <header>
        <h2>Requests Received</h2>
      </header>
      <ul v-if="requestsStore.hasRequests">
        <RequestItem v-for="req in requestsStore.getRequests" :key="req.id" :email="req.email" :message="req.message"/>
      </ul>
      <h3 v-else>You haven't received any requests yet!</h3>
    </BaseCard>
  </section>
</template>

<script setup>
import {useRequestsStore} from '@/stores/requests/index.js';
import RequestItem from '@/components/reuqests/RequestItem.vue';

const requestsStore = useRequestsStore();
</script>

<style scoped>
header {
  text-align: center;
}

ul {
  list-style: none;
  margin: 2rem auto;
  padding: 0;
  max-width: 30rem;
}

h3 {
  text-align: center;
}
</style>