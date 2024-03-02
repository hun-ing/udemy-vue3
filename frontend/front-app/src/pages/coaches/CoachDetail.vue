<template>
  <div>
    <section>
      <BaseCard>
        <h2>{{ coachesStore.getFullNameById(props.id) }}</h2>
        <h3>${{ rate }}/hour</h3>
      </BaseCard>
    </section>
    <section>
      <BaseCard>
        <header>
          <h2>Interested? Reach out now!</h2>
          <BaseButton link :to="contactLink">Contact</BaseButton>
        </header>
        <router-view></router-view>
      </BaseCard>
    </section>
    <section>
      <BaseCard>
        <BaseBadge v-for="area in areas" :key="area.id" :type="area.area" :title="area.area" />
        <p>{{ description }}</p>
      </BaseCard>
    </section>
  </div>
</template>

<script setup>
import {computed, ref} from 'vue';
import {useCoachesStore} from '@/stores/coaches/index.js';
import {useRoute} from 'vue-router';

const route = useRoute();
const coachesStore = useCoachesStore();
const props = defineProps(['id']);
const selectedCoach = ref(null);
const contactLink = computed(() => `${route.path}/contact`);
const areas = computed(() => selectedCoach.value.areas);
const rate = computed(() => selectedCoach.value.hourlyRate);
const description = computed(() => selectedCoach.value.description);

function created() {
  selectedCoach.value = coachesStore.findCoachById(props.id);
  console.log(selectedCoach.value);
}

created();
</script>

<style scoped>

</style>