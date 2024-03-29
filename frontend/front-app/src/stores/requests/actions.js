import {useFetch} from '@vueuse/core';
import {useGlobalStore} from '@/stores/index.js';
import {useAuthStore} from "@/stores/auth/index.js";

export default {
  async contactCoach(requestData) {
    const {error} = await useFetch(
        `http://localhost:8080/api/request`, {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(requestData),
        });

    if (error.value) {
      throw new Error('Failed to send request.');
    }
  },

  async loadRequests() {
    console.log('loadRequests...');
    const authStore = useAuthStore();
    const coachId = authStore.getUserId
    const {data, error} = await useFetch(`http://localhost:8080/api/requests/${coachId}`);

    if (error.value) {
      throw new Error('Failed to fetch requests.');
    }

    this.requests = JSON.parse(data.value);
  },
};