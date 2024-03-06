import React from "react";

export const UiDesign = () => {
  return (
    <div className="w-[50vw] h-[80vh] bg-white rounded-xl ">
      <div className="bg-[#758AA2] p-5 flex gap-5 justify-center rounded-t-xl">
        <input
          className="p-2 rounded-md w-full outline-none px-5 text-black"
          placeholder="Add New Task"
          type="text"
        />
        <button className="py-2 px-5 rounded-md bg-[#2B2B52]">Add</button>
      </div>
      <h1 className="text-black text-center pt-10 font-bold">List Of Todo</h1>
      <div className="p-5 space-y-2 overflow-y-auto h-[60vh]">
        {new Array(5).fill(0).map((item, index) => (
          <div className="bg-[#99AAAB] p-3 rounded-md flex items-center justify-between">
            <div class="">
              <p class="text-gray-900 text-sm">
                {index + 1}. todo{index + 1}.
              </p>
            </div>
            <div class="flex space-x-4">
              <button
                class="text-red-600 hover:text-white focus:outline-none rounded-full hover:bg-red-600 p-2"
                aria-label="Delete"
              >
                <svg
                  class="h-6 w-6"
                  fill="none"
                  viewBox="0 0 24 24"
                  stroke="currentColor"
                >
                  <path
                    stroke-linecap="round"
                    stroke-linejoin="round"
                    stroke-width="2"
                    d="M6 18L18 6M6 6l12 12"
                  ></path>
                </svg>
              </button>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};
