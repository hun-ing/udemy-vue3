export default {
    registerCoach(data) {
        console.log('registerCoach...');
        const coachData = {
            id: 'c3',
            firstName: data.first,
            lastName: data.last,
            description: data.desc,
            hourlyRate: data.rate,
            areas: data.areas
        }

        this.coaches.push(coachData);
    }
}