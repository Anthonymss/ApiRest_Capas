"use client";
import Link from "next/link";

export default function Home() {
  return (
    <div className="container mx-auto">
      <header className="py-5">
        <nav className="bg-white py-2 rounded-xl my-2 shadow-md">
          <ul className="flex flex-row gap-6">
            <li>
              <Link href="/" className="text-black hover:underline">
                Home
              </Link>
            </li>
            <li>
              <Link href="/user" className="text-black hover:underline">
                Car
              </Link>
            </li>
            <li>
              <Link href="/product" className="text-black hover:underline">
                Dealership
              </Link>
            </li>
          </ul>
        </nav>
      </header>
      <main className="text-center my-10">
        <h1 className="text-3xl font-bold">Welcome to the Auto and Dealership Platform</h1>
        <p className="text-lg my-4">Explore cars and dealerships, and manage your data efficiently!</p>
      </main>
    </div>
  );
}
