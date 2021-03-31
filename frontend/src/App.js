import logo from './logo.svg';
import './App.css';
import FormComponent from "./components/FormComponent";

function App() {

  return (
    <div className="min-h-screen  bg-warm-gray-50 flex flex-col justify-center">
      <main>
        <div className="relative">
          <div className="absolute left-0 right-0 h-1/2" aria-hidden="true"></div>
          <div className="relative max-w-md mx-auto px-4 sm:max-w-3xl sm:px-6 lg:max-w-7xl lg:px-8">
            <div
              className="py-10 px-6 bg-gradient-to-l from-light-blue-800 to-cyan-700 rounded-3xl sm:py-16 sm:px-12 lg:py-20 lg:px-20 lg:flex lg:items-center">
              <div className="lg:w-0 lg:flex-1">
                <h2 className="text-3xl font-extrabold tracking-tight text-white">
                  Prime Checker
                </h2>
                <p className="mt-4 max-w-3xl text-lg text-cyan-100">
                  This tool will help you in your everyday life to check if a number is prime or not.
                </p>
              </div>
              <div className="mt-12 sm:w-full sm:max-w-md lg:mt-0 lg:ml-8 lg:flex-1">
                <FormComponent />
                <p className="mt-3 text-sm text-cyan-100">
                  Feeling lost?
                  <a href="https://en.wikipedia.org/wiki/Prime_number" className="text-white font-medium underline ml-1">
                    Learn what is a prime number.
                  </a>
                </p>
              </div>
            </div>
          </div>
        </div>
      </main>
    </div>
  );
}

export default App;
