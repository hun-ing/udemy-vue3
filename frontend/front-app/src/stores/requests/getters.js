import {useGlobalStore} from '@/stores/index.js';

export default {
  getRequests(state) {
    const globalStore = useGlobalStore();
    const coachId = globalStore.userId;
    return state.requests.filter(req => req.coachId === coachId);
  },
  hasRequests(state) {
    return state.getRequests && state.getRequests.length > 0;
  },
}