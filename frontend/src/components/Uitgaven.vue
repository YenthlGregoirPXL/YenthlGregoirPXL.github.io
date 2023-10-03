<template>
  <NavBar></NavBar>
  <div class="uitgave-form">
    <h2>Voeg een Uitgave toe</h2>
    <form @submit.prevent="addUitgave" class="form">
      <div class="form-group">
        <label for="omschrijving">Omschrijving:</label>
        <input v-model="omschrijving" type="text" id="omschrijving" class="form-control">
      </div>
      <div class="form-group">
        <label for="datum">Datum:</label>
        <input v-model="datum" type="date" id="datum" class="form-control">
      </div>
      <div class="form-group">
        <label for="bedrag">Bedrag:</label>
        <input v-model="bedrag" type="number" step="0.01" id="bedrag" class="form-control">
      </div>
      <button type="submit" class="btn btn-primary">Voeg uitgave toe</button>
    </form>
  </div>
</template>

<script>
import NavBar from "@/components/NavBar";
export default {
  name: "uitgavenToevoegen",
  components: {NavBar},
  data() {
    return {
      omschrijving: "",
      datum: "",
      bedrag: 0.0,
    };
  },
  methods: {
    async addUitgave() {
      const formData = {
        omschrijving: this.omschrijving,
        datum: this.datum,
        bedrag: this.bedrag,
      };

      try {
        const response = await fetch("http://localhost:8090/api/Uitgave/toevoegen", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(formData),
        });

        if (response.ok) {
          console.log("Uitgave toegevoegd!");
          // Voeg hier eventueel een redirect of een succesmelding toe
        } else {
          console.error("Failed to add uitgave");
          // Voeg hier eventueel een foutmelding toe
        }
      } catch (error) {
        console.error("An error occurred while adding uitgave:", error);
        // Voeg hier eventueel een foutmelding toe
      }
    },
  },
};
</script>

<style scoped>
.uitgave-form {
  max-width: 400px;
  margin: 0 auto;
  padding: 20px;
  background-color: #ffffff;
  border-radius: 4px;
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
}

.form {
  display: flex;
  flex-direction: column;
}

.form-group {
  margin-bottom: 20px;
}

.label {
  font-weight: bold;
}

.form-control {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

.btn {
  padding: 10px 20px;
  background-color: #007BFF;
  color: #fff;
  border: none;
  border-radius: 4px;
  font-size: 18px;
  cursor: pointer;
  transition: background-color 0.3s;
}

.btn:hover {
  background-color: #0056b3;
}
</style>
