<template>
  <nav class="navbar">
    <router-link to="/">Home</router-link> <!-- Link naar het startscherm -->
    <router-link to="/speeldagenToevoegen">Speeldagen Toevoegen</router-link>
    <router-link to="/uitgavenToevoegen">Uitgaven Toevoegen</router-link>
  </nav>
</template>

<script>
export default {
  name: 'NavBar',
};
</script>

<style scoped>
.navbar {
  background-color: #007BFF;
  color: #fff;
  padding: 10px;
}

.navbar a {
  color: #fff;
  text-decoration: none;
  margin: 0 10px;
}
</style>