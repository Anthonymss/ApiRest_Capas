"use client";
import axios from "axios";
import React, { useEffect, useState } from "react";

const baseURL = "http://localhost:8080/api/v1/auto";

const UsersPage = () => {
  const [users, setUsers] = useState([]);
  const [loading, setLoading] = useState(true);
  const [newCar, setNewCar] = useState({
    marca: "",
    modelo: "",
    anio: "",
    precio: ""
  });

  useEffect(() => {
    axios
      .get(baseURL)
      .then((response) => {
        setUsers(response.data);
      })
      .catch((error) => {
        console.error("Error fetching cars:", error);
      })
      .finally(() => {
        setLoading(false);
      });
  }, []);

  const handleSaveCar = () => {
    axios
      .post(baseURL, newCar)
      .then((response) => {
        setUsers([...users, response.data]);
        setNewCar({ marca: "", modelo: "", anio: "", precio: "" });
      })
      .catch((error) => {
        console.error("Error saving car:", error);
      });
  };

  if (loading) {
    return <div>Loading...</div>;
  }

  return (
    <div className="container mx-auto">
      <h1 className="text-2xl font-bold">Car List</h1>
      <div className="my-4">
        <h2 className="text-xl">Add New Car</h2>
        <input
          type="text"
          placeholder="Marca"
          value={newCar.marca}
          onChange={(e) => setNewCar({ ...newCar, marca: e.target.value })}
          className="block border my-2"
        />
        <input
          type="text"
          placeholder="Modelo"
          value={newCar.modelo}
          onChange={(e) => setNewCar({ ...newCar, modelo: e.target.value })}
          className="block border my-2"
        />
        <input
          type="number"
          placeholder="Año"
          value={newCar.anio}
          onChange={(e) => setNewCar({ ...newCar, anio: e.target.value })}
          className="block border my-2"
        />
        <input
          type="number"
          placeholder="Precio"
          value={newCar.precio}
          onChange={(e) => setNewCar({ ...newCar, precio: e.target.value })}
          className="block border my-2"
        />
        <button onClick={handleSaveCar} className="bg-blue-500 text-white py-1 px-4 rounded">
          Save Car
        </button>
      </div>
      {users.length > 0 ? (
        users.map((user: any) => (
          <div key={user.id} className="my-4 bg-white rounded-2xl p-4 shadow-sm">
            <p className="text-black">Id: {user.id}</p>
            <p className="text-black">Marca: {user.marca}</p>
            <p className="text-black">Modelo: {user.modelo}</p>
            <p className="text-black">Año: {user.anio}</p>
            <p className="text-black">Precio: {user.precio}</p>
          </div>
        ))
      ) : (
        <p className="text-black">No cars available</p>
      )}
    </div>
  );
};

export default UsersPage;
