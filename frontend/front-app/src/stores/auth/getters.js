export default {
  getUserId(state) {
    return state.userId;
  },
  getToken(state) {
    return state.userId;
  },
  isAuthenticated(state) {
    return !!state.token;
  },
  getDidAutoLogout(state) {
    return state.didAutoLogout;
  },
}