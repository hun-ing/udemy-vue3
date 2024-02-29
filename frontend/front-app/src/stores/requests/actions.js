export default {
  contactCoach(data) {
    const newRequest = {
      id: new Date().toISOString(),
      ...data
    };
    this.requests.push(newRequest);
  },
};