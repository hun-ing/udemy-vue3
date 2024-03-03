import {useFetch} from '@vueuse/core';

export default {
  login() {

  },
  async signup(userData) {
    const {data, error} = await useFetch(
        `http://localhost:8080/api/signup`, {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(userData),
        });

    if (error.value) {
      throw new Error('Failed to authenticate.');
    }

    const parseData = JSON.parse(data.value);

    this.token = parseData.token;
    this.userId = parseData.userId;
  }
};