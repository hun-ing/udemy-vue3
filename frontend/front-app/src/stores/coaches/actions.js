import {useFetch} from '@vueuse/core';

export default {
  async registerCoach(coachData) {
    console.log('registerCoach...');
    const newCoachData = {
      firstName: coachData.first,
      lastName: coachData.last,
      description: coachData.desc,
      hourlyRate: coachData.rate,
      areas: coachData.areas,
    };

    const {data, error} = await useFetch(
        `http://localhost:8080/api/coach`, {
          method: 'PUT',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(newCoachData),
        });

    if (error.value) {
      throw new Error('Failed to fetch!!');
    }

    this.coaches.push(JSON.parse(data.value));
  },
  async loadCoaches() {
    const {data, error} = await useFetch(`http://localhost:8080/api/coaches`);

    if (error.value) {
      throw new Error('Failed to fetch!!');
    }

    console.log('data = ', JSON.parse(data.value));
    this.coaches = JSON.parse(data.value);
  },
};