import { useGlobalStore } from '@/stores/index.js'

export default {
    registerCoach(data) {
        console.log('registerCoach...');
        const globalStore = useGlobalStore()
        const coachData = {
            id: globalStore.userId,
            firstName: data.first,
            lastName: data.last,
            description: data.desc,
            hourlyRate: data.rate,
            areas: data.areas
        }

        this.coaches.push(coachData);
    }
}