export default {
  getRequests(state) {
    return state.requests;
  },

  hasRequests(state) {
    return state.getRequests && state.getRequests.length > 0;
  },
}