<template>
  <NavBar></NavBar>
  <div class="container">
    <h2 class="title">Voeg een speeldag toe</h2>
    <form @submit.prevent="addSpeeldag" class="form">
      <div class="form-group">
        <label  class="label">Selecteer een team:</label>
        <select v-model="selectedTeam" id="team" class="select">
          <option v-for="teamName in teamNames" :key="teamName" :value="teamName">{{ teamName }}</option>
        </select>
      </div>
      <div class="form-group">
        <label for="date" class="label">Datum:</label>
        <input v-model="selectedDate" type="date" id="date" class="input">
      </div>
      <div class="form-group">
        <label for="amount" class="label">Bedrag:</label>
        <input v-model="bedrag" type="number" step="0.01" id="amount" class="input">
      </div>
      <button type="submit" class="button">Voeg speeldag toe</button>
    </form>
  </div>
</template>

<script>
import NavBar from "@/components/NavBar";
export default {
  components: {NavBar},
  data() {
    return {
      teams: [], // Array to hold the teams fetched from the backend
      selectedTeam: "", // Selected team from dropdown
      selectedDate: "", // Selected date
      bedrag: 0.0, // Default bedrag value
    };
  },
  computed: {
    // Computed property to extract team names from the fetched teams
    teamNames() {
      return this.teams.map((team) => team.naam);
    },
  },
  methods: {
    // Fetch teams from the backend (replace with your actual endpoint)
    async fetchTeams() {
      try {
        const response = await fetch("http://localhost:8090/api/team");
        if (response.ok) {
          this.teams = await response.json();
        } else {
          console.error("Failed to fetch teams");
        }
      } catch (error) {
        console.error("An error occurred while fetching teams:", error);
      }
    },
    // Add a new "speeldag" by sending data to the backend (replace with your actual endpoint)
    async addSpeeldag() {
      const formData = {
        tegenstanderNaam: this.selectedTeam,
        datum: this.selectedDate,
        bedrag: this.bedrag,
      };

      try {
        const response = await fetch("http://localhost:8090/api/speeldagen/toevoegen", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(formData),
        });

        if (response.ok) {
          console.log("Speeldag toegevoegd!");
        } else {
          console.error("Failed to add speeldag");
        }
      } catch (error) {
        console.error("An error occurred while adding speeldag:", error);
      }
    },
  },
  mounted() {
    // Fetch teams when the component is mounted
    this.fetchTeams();
  },
};
</script>
<style scoped>
.container {
  max-width: 400px;
  margin: 10% auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  background-color: #fff;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.title {
  font-size: 24px;
  margin-bottom: 20px;
}

.form-group {
  margin-bottom: 15px;
}

.label {
  font-size: 16px;
  display: block;
  margin-bottom: 5px;
}

.select,
.input {
  width: 100%;
  padding: 10px;
  font-size: 16px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

.button {
  background-color: #007BFF;
  color: #fff;
  border: none;
  border-radius: 4px;
  padding: 10px 20px;
  font-size: 16px;
  cursor: pointer;
}

.button:hover {
  background-color: #0056b3;
}
</style>