"use client";
import axios from "axios";
import React, { useEffect, useState } from "react";

const baseURL = "http://localhost:8080/api/v1/dealership";

const ProductPage = () => {
  const [products, setProducts] = useState([]);
  const [loading, setLoading] = useState(true);
  const [newDealership, setNewDealership] = useState({
    name: "",
    address: ""
  });

  useEffect(() => {
    axios
      .get(baseURL)
      .then((response) => {
        setProducts(response.data);
      })
      .catch((error) => {
        console.error("Error fetching dealerships:", error);
      })
      .finally(() => {
        setLoading(false);
      });
  }, []);

  const handleSaveDealership = () => {
    axios
      .post(baseURL, newDealership)
      .then((response) => {
        setProducts([...products, response.data]);
        setNewDealership({ name: "", address: "" });
      })
      .catch((error) => {
        console.error("Error saving dealership:", error);
      });
  };

  if (loading) {
    return <div>Loading...</div>;
  }

  return (
    <div className="container mx-auto">
      <h1 className="text-2xl font-bold">Dealership List</h1>
      <div className="my-4">
        <h2 className="text-xl">Add New Dealership</h2>
        <input
          type="text"
          placeholder="Name"
          value={newDealership.name}
          onChange={(e) => setNewDealership({ ...newDealership, name: e.target.value })}
          className="block border my-2"
        />
        <input
          type="text"
          placeholder="Address"
          value={newDealership.address}
          onChange={(e) => setNewDealership({ ...newDealership, address: e.target.value })}
          className="block border my-2"
        />
        <button onClick={handleSaveDealership} className="bg-blue-500 text-white py-1 px-4 rounded">
          Save Dealership
        </button>
      </div>
      {products.length > 0 ? (
        products.map((product: any) => (
          <div key={product.id} className="my-4 bg-white rounded-2xl p-4 shadow-sm">
            <p className="text-black">Id: {product.id}</p>
            <p className="text-black">Name: {product.name}</p>
            <p className="text-black">Address: {product.address}</p>
          </div>
        ))
      ) : (
        <p className="text-black">No dealerships available</p>
      )}
    </div>
  );
};

export default ProductPage;
