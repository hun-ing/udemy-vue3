<template>
  <div>
    <BaseDialog :show="!!error" title="An error occurred!" @close="dialogHandleError">
      <p>{{error}}</p>
    </BaseDialog>
    <section>
      <BaseCard>
        <header>
          <h2>Requests Received</h2>
        </header>
        <BaseSpinner v-if="isLoading"></BaseSpinner>
        <ul v-else-if="requestsStore.hasRequests && !isLoading">
          <RequestItem v-for="req in requestsStore.getRequests" :key="req.id" :email="req.email" :message="req.message" />
        </ul>
        <h3 v-else>You haven't received any requests yet!</h3>
      </BaseCard>
    </section>
  </div>
</template>

<script setup>
import {useRequestsStore} from '@/stores/requests/index.js';
import RequestItem from '@/components/reuqests/RequestItem.vue';
import {onMounted, ref} from 'vue';

const requestsStore = useRequestsStore();

const isLoading = ref(false);
const error = ref(null);
const loadRequests = async () => {
  isLoading.value = true;
  try {
    await requestsStore.loadRequests();
  } catch (e) {
    error.value = e.message || 'Something failed!!';
  }
  isLoading.value = false;
};
const dialogHandleError = () => error.value = null;

onMounted(() => loadRequests());
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